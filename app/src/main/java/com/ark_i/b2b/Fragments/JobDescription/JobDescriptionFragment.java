package com.ark_i.b2b.Fragments.JobDescription;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;

import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ark_i.b2b.Adapters.AdapterForNotes;
import com.ark_i.b2b.Models.ModelClassForNotes;
import com.ark_i.b2b.R;
import com.ark_i.b2b.databinding.FragmentJobDescriptionBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;




public class JobDescriptionFragment extends Fragment implements OnMapReadyCallback {
    FragmentJobDescriptionBinding binding;

    GoogleMap mMap;
        ArrayList<ModelClassForNotes> list;
    AdapterForNotes adapter;
    RecyclerView recyclerView;




    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int PICK_PDF_REQUEST = 2;
    private static final int PERMISSION_REQUEST_CODE = 100;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJobDescriptionBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecycleSetup(view);




        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mappp);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);

        }
//--------------------------ONCLICKS--------------------------------------
        binding.branchInfoBtn.setOnClickListener(v -> showPopupWindow());
        binding.JoMiBo.setOnClickListener(v -> {

            if(getContext()!=null){
                if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_MEDIA_IMAGES)
                        != PackageManager.PERMISSION_GRANTED){
                    askPermission();

                }else {
                    openGallery();
                }
            }






        });
        binding.BoxDoc.setOnClickListener(v -> {
            if((ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED) ){
                openFilePicker();
            }else {
                askPermission();
            }

        });

//--------------------------------------------------------------------------


    }

    void RecycleSetup(View view){
        recyclerView = view.findViewById(R.id.Recycleviewnotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new AdapterForNotes(getContext(),list);
        recyclerView.setAdapter(adapter);

    }


    private void renderPdfPreview(Uri pdfUri) {
        try {
            // Convert the Uri to a FileDescriptor
            if(getContext()!=null){
                ParcelFileDescriptor fileDescriptor = getContext().getContentResolver().openFileDescriptor(pdfUri, "r");
                if (fileDescriptor != null) {
                    PdfRenderer pdfRenderer = new PdfRenderer(fileDescriptor);

                    // Open the first page of the PDF
                    PdfRenderer.Page page = pdfRenderer.openPage(0);

                    // Create a bitmap to render the PDF page into
                    Bitmap bitmap = Bitmap.createBitmap(page.getWidth(), page.getHeight(), Bitmap.Config.ARGB_8888);

                    // Render the PDF page into the bitmap
                    page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

                    // Set the bitmap to the ImageView to display the preview
                    binding.PDFIMAGE.setImageBitmap(bitmap);

                    // Close the page and PdfRenderer
                    page.close();
                    pdfRenderer.close();
                    fileDescriptor.close();
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void askPermission() {
        if(getActivity()!=null){
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_MEDIA_IMAGES},
                    PERMISSION_REQUEST_CODE);
        }


    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("application/pdf"); // Filter to show only PDF files
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, PICK_PDF_REQUEST);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            }
            else {
                askPermission();
                Toast.makeText(requireActivity(), "PLEASE PROVIDE THE REQUIRED PERMISSION", Toast.LENGTH_LONG).show();

            }
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK && data != null) {
            Uri fileUri = data.getData();
            if (fileUri != null) {
                switch (requestCode) {
                    case PICK_PDF_REQUEST:
                        renderPdfPreview(fileUri);

                        break;
                    case PICK_IMAGE_REQUEST:

                        Picasso.get().load(fileUri).into(binding.imgone);
                        break;
                    default:
                        Toast.makeText(getActivity(), "Unsupported file type", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }





    }


    private void openGallery() {
        if((ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)){
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
            Toast.makeText(requireActivity(), "YES PERMISSION", Toast.LENGTH_SHORT).show();
        }


    }


    private void showPopupWindow() {
        // Inflate the popup window layout
        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // Create the PopupWindow
        PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true);

        // Convert 10dp to pixels for margins (if needed)
        int topMarginPx = dpToPx(10); // Margin between the anchor view and the popup

        // Get the anchor view (button) from the layout
        View anchorView = binding.branchInfoBtn;

        // Get the display dimensions to calculate the center of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();

            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);


        int screenWidth = displayMetrics.widthPixels;

        // Measure the popup window's width to center it
        popupView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWidth = popupView.getMeasuredWidth();

        // Calculate the X position to center the popup
        int xPos = (screenWidth - popupWidth) / 2;

        // Calculate the Y position to position it below the anchor view
        int[] location = new int[2];
        anchorView.getLocationOnScreen(location);
        int yPos = location[1] + anchorView.getHeight() + topMarginPx;

        // Show the popup window centered horizontally and below the anchor view
        popupWindow.showAtLocation(anchorView,
                Gravity.NO_GRAVITY, // Use NO_GRAVITY for precise positioning
                xPos, // X position (centered horizontally)
                yPos); // Y position (below the anchor view plus top margin)
    }

    // Helper method to convert dp to pixels
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Define origin and destination
        LatLng origin = new LatLng(31.471632, 74.451084);
        LatLng destination = new LatLng(31.472305, 74.463701);

        // Add markers for origin and destination
        mMap.addMarker(new MarkerOptions().position(origin).title("Start Point").icon(BitmapDescriptorFactory.fromResource(R.drawable.vectororign)));
        mMap.addMarker(new MarkerOptions().position(destination).title("End Point").icon(BitmapDescriptorFactory.fromResource(R.drawable.vectordestination)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(origin, 15f));

        // Get directions from origin to destination
        getDirections(origin, destination);
    }

    private void getDirections(LatLng origin, LatLng destination) {
        String url = "https://maps.googleapis.com/maps/api/directions/json?" +
                "origin=" + origin.latitude + "," + origin.longitude +
                "&destination=" + destination.latitude + "," + destination.longitude +
                "&mode=driving&key=AIzaSyC_XTc_Snlg04x2F1av5B2jhpdHEFLkJ4o";

        // Request a JSON response from the provided URL
        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray routes = response.getJSONArray("routes");
                        JSONObject route = routes.getJSONObject(0);
                        JSONObject overviewPolyline = route.getJSONObject("overview_polyline");
                        String encodedPolyline = overviewPolyline.getString("points");
                        List<LatLng> polylinePoints = decodePolyline(encodedPolyline);

                        // Draw the polyline
                        PolylineOptions polylineOptions = new PolylineOptions()
                                .addAll(polylinePoints)
                                .width(10)
                                .color(android.graphics.Color.RED);

                        mMap.addPolyline(polylineOptions);

                    } catch (JSONException e) {
                        Toast.makeText(requireActivity(), "", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show());

        // Add the request to the RequestQueue
        requestQueue.add(jsonObjectRequest);
    }

    // Method to decode polyline points
    private List<LatLng> decodePolyline(String encoded) {
        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }
        return poly;
    }
}