package harshbarash.github.io;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DialogFragment extends Fragment {

    Button login, register;

    FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_start, container, false);
        Button login = (Button) view.findViewById(R.id.loginBtn);
        Button register = (Button) view.findViewById(R.id.registerbtn);



        //перенаправляем

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.loginBtn:
                        Intent intent = new Intent(DialogFragment.this.getActivity(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.registerbtn:
                        Intent intenttwo = new Intent(DialogFragment.this.getActivity(), RegisterActivity.class);
                        startActivity(intenttwo);
                        break;
                }
            }
        };
        login.setOnClickListener(onClickListener);
        register.setOnClickListener(onClickListener);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            Intent intent = new Intent(DialogFragment.this.requireContext(), ChatActivity.class);
            startActivity(intent);

//            Intent intent = new Intent();
//            intent.setClass(getActivity(), ChatActivity.class);
//            startActivity(intent);
        }
    }
}