package vn.edu.usth.usthweather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView textView = new TextView(getContext());
        textView.setTextColor(Color.parseColor("#21130d"));
        textView.setTextSize(24f);
        String text = "what's up!";
        textView.setText(text);

        // Create a new LinearLayout
        LinearLayout otherLayout = new LinearLayout(getContext());
        otherLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        otherLayout.setOrientation(LinearLayout.VERTICAL);
        otherLayout.setVisibility(View.GONE);


        // Create Edit text
        EditText editText = new EditText(getContext());
        editText.setHint("Here are a Space for you Writing.");
        otherLayout.addView(editText);

        ImageView img = new ImageView(getContext());
        img.setImageResource(R.drawable.weather);

        // Create a button
        Button button = new Button(getContext());
        button.setText("Click me, You will be come a Writer!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (otherLayout.getVisibility() == View.VISIBLE)
                {
                    otherLayout.setVisibility(View.GONE);
                }else {
                    otherLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        // Inflate the layout for this fragment
        FrameLayout view = new FrameLayout(getContext());
        // Set color of background.
        view.setBackgroundColor(Color.parseColor("#e5ebe7"));

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setBackgroundColor(Color.parseColor("#2ea0c4"));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        view.addView(linearLayout);
        linearLayout.addView(img);
        linearLayout.addView(textView);
        linearLayout.addView(button);
        linearLayout.addView(otherLayout);

        return view;
    }



}