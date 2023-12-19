package com.example.project02_last.map;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.project02_last.R;
import com.example.project02_last.databinding.FragmentKmjMapBinding;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraAnimation;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.util.FusedLocationSource;

import java.util.ArrayList;


public class KmjMapFragment extends Fragment implements OnMapReadyCallback {

    FragmentKmjMapBinding binding;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;
    private NaverMap naverMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentKmjMapBinding.inflate(inflater, container, false);

        NaverMapSdk.getInstance(getContext()).setClient(
                new NaverMapSdk.NaverCloudPlatformClient(""));
//        clientId : 메니페스트와 여기에 넣어줘야함

        locationSource =
                new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        binding.mapView.getMapAsync(this);
        return binding.getRoot();
    }

    @UiThread
    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
//        NaverMapOptions options = new NaverMapOptions()
//                .camera(new CameraPosition(new LatLng(33.2372663, 126.5157058), 5))
//        naverMap.setMapType(NaverMap.MapType.Basic); 맵의 타입을 변경 : 위성, 네비 등...

        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(new LatLng(33.2372663, 126.5157058))
                        .animate(CameraAnimation.Fly,1000);
        naverMap.moveCamera(cameraUpdate);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);

        this.naverMap = naverMap;
        naverMap.setLocationSource(locationSource);

        ArrayList<Marker> list = new ArrayList<>();
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        list.add(new Marker());
        for (int i =0;  i<list.size(); i++){
            list.get(i).setPosition(new LatLng(33.2372663+(i*0.001), 126.5157058+(i*0.001)));
            list.get(i).setMap(naverMap);
        }
        Marker marker = new Marker();
        marker.setPosition(new LatLng(33.2372663, 126.5157058));
        marker.setMap(naverMap);


        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING, true);// 건물표시
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRANSIT, true);// 대중교통 표시
        naverMap.setIndoorEnabled(true);

    }
}