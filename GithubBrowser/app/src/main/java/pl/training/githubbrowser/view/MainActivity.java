package pl.training.githubbrowser.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by fist on 2016-09-10.
 */
public class MainActivity extends AppCompatActivity {

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

	}

	@OnClick(R.id.button_search)
	void loadRepos() {
		progressBar.setVisibility(View.VISIBLE);
		reposRecyclerView.setVisibility(View.GONE);
		infoTextView.setVisibility(View.GONE);
		GithubBrowserApplication application = GithubBrowserApplication.get(this);
		GitHub github = application.getGithub();
		subscription = github.publicRepositories(editText.getText().toString())
			.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(application.getDefaultScheduler())
				.subscribe(new Subscriber<List<Repository>>() {

					@Override
					public void onCompleted() {

					}

					@Override
					public void onError(Throwable e) {

					}

					@Override
					public void onNext(List<Repository> repositories) {

					}
				};);


	}

}
