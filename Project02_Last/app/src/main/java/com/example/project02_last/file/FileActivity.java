package com.example.project02_last.file;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.project02_last.R;
import com.example.project02_last.common.CommonRetClient;
import com.example.project02_last.common.CommonService;
import com.example.project02_last.databinding.ActivityFileBinding;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FileActivity extends AppCompatActivity {

        ActivityFileBinding binding;
        ActivityResultLauncher<Intent> launcher;// => onCreate 메소드에서 초기화하면 오류 발생
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkPermission();

        //        캐싱되어있는 이미지를 삭제함 -> 나중에 이미지가 많으면 새로 로딩을 다시 하기 때문에 느려질 가능성 있음
//                작업 시간이 걸려서
       // new ClearCacheTask(this).execute();
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Glide.get(FileActivity.this).clearDiskCache();
//                Glide.get(FileActivity.this).clearMemory();
//            }
//        });

        Glide.with(this).load("http://192.168.0.46/mid/file/test.jpg").into(binding.imgv);
        
        binding.imgv.setOnClickListener(v -> {

            //여러 화면에서 재활용이 필요하다면 바뀌어야 할 부분들을 전부 파라미터로 뺴고, 메소드 형태로 바꿔주면 편함
            //AlertDialog -> Builder
            String[] dialog_item = {"갤러리", "카메라"};
            AlertDialog.Builder builder = new AlertDialog.Builder(FileActivity.this);
            builder.setTitle("사진 업로드 방식");
            builder.setSingleChoiceItems(dialog_item, -1, (dialog, i) -> {

                if(dialog_item[i].equals("갤러리")){
                    showGallery();
                } else if ( i == 1) {
                    showCamera();
                }
                dialog.dismiss(); // 아이템 선택 후 안보이게 처리
            } );
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Glide.with(FileActivity.this).load(cameraUri).into(binding.imgv);
            File cameraFile = new File(getRealPath(cameraUri));

//            MultiPart 형태로 전송 ( File)
//            재사용이 필요하다면 CommonConn 부분에 넣어주는 것도 가능함(추후)
//            MediaType 어떤 형태의 데이터 확장자나 타입인지 명시
//
            RequestBody file = RequestBody.create(MediaType.parse("image/jpeg"), cameraFile);
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("andFile", "test.jpg", file); //name : servelet 구분자, 실제 파일명, 실제 파일
            CommonService service = CommonRetClient.getApiClient().create(CommonService.class);
            service.clientSendFile("file.f", new HashMap<>(), filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        });
    }

    //    이전까지 많이 사용되던 비동기 작업 (백그라운드)
    class ClearCacheTask extends AsyncTask<Void, Void, Void>{

    private Context context;

    public ClearCacheTask(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Glide.get(FileActivity.this).clearDiskCache();
//        Glide.get(FileActivity.this).clearMemory();
        return null;
    }
}

    final int GALLERY_REQ = 1000;
    final int CAMERA_REQ = 1001;

//    os를 통해서 갤러리의 액티비티를 띄움 ( 사용자가 선택 -> 결과를 받아옴)\
//    Intent를 이용한 화면 전환 : 명시적 (Activity->Activity), 묵시적(암시적) (Activity -> Action(Activity)
    public void showGallery(){
        Intent intent =  new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
//        startActivity(intent); 단순 실행, 결과(상태)를 알 수 없음(사진선택, 뒤로 가기, 대기)
//        1.startActivityForResult == Legacy : RequestCode( 어떤 요청, 구분자), onActivityResult라는 메소드를 재정의
            startActivityForResult(intent, GALLERY_REQ);
//        2.ActivityLauncher -> 최근

    }

    Uri cameraUri = null;
//    ActivityLauncher
    public void showCamera(){
//        카메라로 사용자가 사진을 찍으면, 우리가 미리 임시로 만들어둔 URI에 카메라 사진을 외부 저장소에 저장 후 알려줌
        cameraUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        launcher.launch(cameraIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("갤러리", "onActivityResult: "+ requestCode+" : "+ resultCode);
        if(requestCode == GALLERY_REQ && resultCode == RESULT_OK){
//      상수 사용
            Log.d("갤러리", "onActivityResult: "+data.getData());
            Log.d("갤러리", "onActivityResult: "+data.getData().getPath());
//            안드로이드에서만 읽어볼 수 있는 이미지 경로 -> (서버로 전송이 불가능) -> 권한이 필요
//            onActivityResult: content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F36/ORIGINAL/NONE/image%2Fjpeg/65605899
//            onActivityResult: /-1/1/content://media/external/images/media/36/ORIGINAL/NONE/image/jpeg/65605899
//            c:fakedirectory

            Glide.with(this).load(data.getData()).into(binding.imgv);//불러온 이미지를 이미지 뷰에 붙일 수 있는지?
            getRealPath(data.getData());
            String filePath = getRealPath(data.getData());
            
//            MultiPart 형태로 전송 ( File)
//            재사용이 필요하다면 CommonConn 부분에 넣어주는 것도 가능함(추후)
            //            MediaType 어떤 형태의 데이터 확장자나 타입인지 명시
            RequestBody file = RequestBody.create(MediaType.parse("image/jpeg"), new File(filePath));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("andFile", "test.jpg", file); //name : servelet 구분자, 실제 파일명, 실제 파일
            CommonService service = CommonRetClient.getApiClient().create(CommonService.class);
            service.clientSendFile("file.f", new HashMap<>(), filePart).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        } else if(requestCode == CAMERA_REQ){

        }
    }

//    ContentResolver라는 컴포넌트를 이용하여 Uri를 통해 실제 이미지의 경로를 조회한다.
//    Android 내부에 있는 모든 요소들은 전부 table형태로 저장이 되어있음

//    Multipart : 파일이나 이미지와 같은 바이너리 데이터를 서버에 전송할 때 사용함.
//    여러 종류의 데이터를 하나의 요청에 여러 부분으로 나눠서 전송처리를 한다. ( 이메일을 보낼 때 텍스트 영역과 별도로 파일 첨부가 있는 형태)
//    파일 -> Input, Output -> 이미지 파일 byte 수 만큼 -> 숫자 형태로 되어있음.
//    GET요청을 불가능 (URL에 데이터 제한이 있음. 이진 데이터를 구별 불가능 String) Post요청이 필수임. (웹에서도 마찬가지임) POST, MULTIPART  세트임
//    http 요청 : 텍스트 데이터를 주고받는 데 사용함 (파일은 이진 데이터를 포함 해야함)

//  사용만 할줄 알면..
    public String getRealPath(Uri contentUri){
        String res = null; // 문자열 변수로 리턴하기 위해 변수 초기화
        String[] cols = {MediaStore.Images.Media.DATA};//컬럼 이름을 받아옴 (조회 시 alias) select data data from mediastore
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {// query(Api26 이전 버전은 확인 불필요, 그냥 경로를 줌)
            Cursor cursor = getContentResolver().query(contentUri, cols, null, null);
            if(cursor.moveToFirst()){
                int colulm_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                res = cursor.getString(colulm_index);
            }
        }

        Log.d("갤러리", "getRealPath: "+res);
        return res;
    }

    public final int REQ_PERMISSION = 900;
    public final int REQ_PERMISSION_DENY = 901;
    private void checkPermission(){
        ////        editor.putInt("permission" , 0);//데이터 0이 들어감.
        ////        editor.apply();//데이터를 확실히 넣음.
//        int permission = pref.getInt("permission" , -1);
//        permission++;
//        editor.putInt("permission" , permission);
//        editor.apply();

//        Manifest.xml -> 내부에 있는 권한 요청들이 재확인이 필요한 경우 전부 배열로 받아옴.

        String[] permissions = { Manifest.permission.CAMERA  ,
                Manifest.permission.ACCESS_MEDIA_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE

        } ;//카메라 권한을 String으로 가져옴.


        // ContextCompat(액티비티가 아닌곳) , ActivityCompat(액티비티)
        for(int i = 0 ; i <permissions.length ; i ++){
            //내가 모든 권한이 필요하다면 전체 권한을 하나씩 체크해서 허용 안됨이 있는경우 다시 요청을 하게 만든다.
            if(ActivityCompat.checkSelfPermission(this , permissions[i]) == PackageManager.PERMISSION_DENIED) {
                if(ActivityCompat.shouldShowRequestPermissionRationale(this , permissions[i])){
                    //최초 앱이 설치되고 실행 시 false가 나옴.=>사용자가 거부 후 true 재거부=>false
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("권한 요청").setMessage("권한이 반드시 필요합니다.!!미허용시 앱 사용 불가!");
                    builder.setPositiveButton("확인(권한허용)" , (dialog, which) -> {
                        //2.권한 설명 후 다시보여줌.
                        ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION_DENY);
                    });
                    builder.setNegativeButton("종료(권한허용불가)" , (dialog, which) -> {
                        finish();
                    });
                    builder.create().show();//<==넣어줘야함.
                }else{
                    //1.
                    ActivityCompat.requestPermissions(this, permissions, REQ_PERMISSION);
                }
                break;
            }
        }

        // int result = ActivityCompat.checkSelfPermission(this , permissions[0]);
        // Log.d("권한", "checkPermission: " + result);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_GRANTED);
//        Log.d("권한", "checkPermission: " + PackageManager.PERMISSION_DENIED);
//
//        if(ActivityCompat.shouldShowRequestPermissionRationale(this , permissions[0])){
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 필요한 권한. ");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }else{
//            Log.d("권한", "shouldShowRequestPermissionRationale: 설명이 x");
//            ActivityCompat.requestPermissions(this,permissions , REQ_PERMISSION);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(REQ_PERMISSION == requestCode){
            for (int i = 0; i < grantResults.length; i++) {
                if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                    //거절된권한이있음.
                    checkPermission();
                    break;
                }
            }

            Log.d("권한", "onRequestPermissionsResult: 권한 요청 완료 ");
        }else if(REQ_PERMISSION_DENY == requestCode){
            for (int i = 0; i < grantResults.length; i++) {
                if(grantResults[i] == PackageManager.PERMISSION_DENIED){
                    Log.d("권한", "onRequestPermissionsResult: 다시 권한요청 화면을 띄울수가 없음.2회 거절당함. ");
//                    editor.putInt("permission" , -2);
                    //3.
//                    viewSetting();
                    //checkPermission();
                }
            }

        }
    }
//    사용자가 권한 거부후 직접 권한 설정하게 세팅창 띄움
//    public void viewSetting(){
//        Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
//        intent.setData(Uri.parse("package:"+getApplicationContext().getPackageName()));
//        startActivity(intent);
//    }
}