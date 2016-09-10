package pl.training.githubbrowser.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.training.githubbrowser.GithubBrowserApplication;
import pl.training.githubbrowser.R;
import pl.training.githubbrowser.model.GitHub;
import pl.training.githubbrowser.model.Repository;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by fist on 2016-09-10.
 */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";

	Subscription subscription;

	@BindView(R.id.repos_recycler_view)
	RecyclerView reposRecyclerView;

	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@BindView(R.id.edit_text_username)
	EditText editText;

	@BindView(R.id.progress)
	ProgressBar progressBar;

	@BindView(R.id.text_info)
	TextView infoTextView;

//	@BindView(R.id.button_search)
//	Button search;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
	}

	@OnClick(R.id.button_search)
	void loadRepos() {
//		throw new RuntimeException("AAAA");
		progressBar.setVisibility(View.VISIBLE);
		reposRecyclerView.setVisibility(View.GONE);
		infoTextView.setVisibility(View.GONE);
//		search.setVisibility(View.GONE);
	}

}
