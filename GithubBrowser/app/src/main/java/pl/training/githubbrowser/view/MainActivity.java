package pl.training.githubbrowser.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.training.githubbrowser.R;
import pl.training.githubbrowser.model.Repository;
import pl.training.githubbrowser.presenter.MainPresenter;
import pl.training.githubbrowser.presenter.Presenter;
import pl.training.githubbrowser.presenter.PresenterBinder;
import rx.Subscription;

/**
 * Created by fist on 2016-09-10.
 */
public class MainActivity extends AppCompatActivity implements MainView {

	private static final String TAG = "MainActivity";
	private Presenter presenter;

	Subscription subscription;

	@Bind(R.id.repos_recycler_view)
	RecyclerView reposRecyclerView;

	@Bind(R.id.toolbar)
	Toolbar toolbar;

	@Bind(R.id.edit_text_username)
	EditText editText;

	@Bind(R.id.progress)
	ProgressBar progressBar;

	@Bind(R.id.text_info)
	TextView infoTextView;

	@Bind(R.id.button_search)
	ImageButton search;
	private MainPresenter mainPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		PresenterBinder.bind(this);

		setupRecyclerView(reposRecyclerView);
	}

	@OnClick(R.id.button_search)
	void loadRepos() {
		progressBar.setVisibility(View.VISIBLE);
		reposRecyclerView.setVisibility(View.GONE);
		infoTextView.setVisibility(View.GONE);
		search.setVisibility(View.GONE);
		mainPresenter.loadRepositories(editText.getText().toString());
	}

	@Override
	public void showRepositories(List<Repository> repositories) {
		Log.d(TAG, "Showing repositories");
		progressBar.setVisibility(View.GONE);
		reposRecyclerView.setVisibility(View.VISIBLE);
		RepositoryAdapter adapter = (RepositoryAdapter) reposRecyclerView.getAdapter();
		adapter.setRepositories(repositories);
	}

	@Override
	public void setPresenter(MainPresenter presenter) {
		this.mainPresenter = presenter;
	}

	private void setupRecyclerView2(RecyclerView recyclerView) {
		RepositoryAdapter adapter = new RepositoryAdapter();
		adapter.setCallback(new RepositoryAdapter.Callback() {
			@Override
			public void onItemClick(Repository repository) {
				startActivity(RepositoryActivity.newIntent(MainActivity.this, repository));
			}
		});
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	private void setupRecyclerView(RecyclerView recyclerView) {
		RepositoryAdapter adapter = new RepositoryAdapter();
		adapter.setCallback(new RepositoryAdapter.Callback() {
			@Override
			public void onItemClick(Repository repository) {
				startActivity(RepositoryActivity.newIntent(MainActivity.this, repository));
			}
		});
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (subscription != null) subscription.unsubscribe();
	}

}
