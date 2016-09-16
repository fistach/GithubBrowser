package pl.training.githubbrowser.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pl.training.githubbrowser.model.GitHub;
import pl.training.githubbrowser.model.Repository;
import pl.training.githubbrowser.view.MainView;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by fist on 2016-09-10.
 */
public class MainPresenter implements Presenter<MainView> {

	private static final String TAG = "MainPresenter";
	private MainView mainView;
	private Subscription subscription;
	private GitHub gitHub;
	private Observable<ArrayList<Repository>> observableReposList = Observable.just(new ArrayList<Repository>());

	public MainPresenter() {
		gitHub = GitHub.Factory.create();
	}

	@Override
	public void attachView(MainView view) {
		mainView = view;
	}

	@Override
	public void detachView() {
		mainView = null;
		if (subscription != null) {
			subscription.unsubscribe();
		}

	}

	public void loadRepositories(String username) {

		subscription = gitHub.publicRepositories(username)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(new Subscriber<List<Repository>>() {

					@Override
					public void onCompleted() {
						Log.d(TAG, "Completed!");

					}

					@Override
					public void onError(Throwable error) {
						Log.d(TAG, "Error: "+error);
					}

					@Override
					public void onNext(List<Repository> repositories) {
						Log.d(TAG, "onNext");
						mainView.showRepositories(repositories);
					}
				});
	}

	public void setGitHub(GitHub gitHub) {
		this.gitHub = gitHub;
	}
}
