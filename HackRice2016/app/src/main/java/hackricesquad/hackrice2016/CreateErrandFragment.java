package hackricesquad.hackrice2016;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateErrandFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateErrandFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateErrandFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Callback cb;
    private EditText editText;
    private EditText editRadius;

    private OnFragmentInteractionListener mListener;

    public CreateErrandFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateErrandFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateErrandFragment newInstance(String param1, String param2) {
        CreateErrandFragment fragment = new CreateErrandFragment();
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
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_create_errand, container, false);

        Button setLocation = (Button) rootView.findViewById(R.id.set_location);
        Button cancelButton = (Button) rootView.findViewById(R.id.cancel_button);
        final Button createEvent = (Button) rootView.findViewById(R.id.create_event);
        editText = (EditText) rootView.findViewById(R.id.edit_event_name);
        editRadius = (EditText) rootView.findViewById(R.id.set_radius);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        final TimePickerFragment t = new TimePickerFragment();
        final DatePickerFragment d = new DatePickerFragment();

        ft.commit();

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgendaItem agendaItem = new AgendaItem();
                agendaItem.setTitle(editText.getText().toString());
                agendaItem.setOwner(ParseUser.getCurrentUser());
                agendaItem.setRadius(Integer.parseInt(editRadius.getText().toString()));
                agendaItem.saveInBackground();
                Intent i = new Intent(getActivity(), AgendaListActivity.class);
                startActivity(i);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AgendaListActivity.class);
                startActivity(i);
            }
        });


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface Callback {
        void callback();
    }

}