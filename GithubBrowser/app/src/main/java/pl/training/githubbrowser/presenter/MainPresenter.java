package pl.training.githubbrowser.presenter;

import pl.training.githubbrowser.view.MainView;
import rx.Subscription;

/**
 * Created by fist on 2016-09-10.
 */
public class MainPresenter implements Presenter<MainView> {


	private MainView mainView;
	private Subscription subscription;

	@Override
	public void attachView(MainView view) {
		mainView = view;
	}

	@Override
	public void detachView() {
		mainView = null;
		if (subscription != null ) {
			subscription.unsubscribe();
		}
				
	}


}
