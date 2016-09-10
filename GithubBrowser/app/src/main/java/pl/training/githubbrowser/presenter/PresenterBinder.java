package pl.training.githubbrowser.presenter;

import pl.training.githubbrowser.view.MainView;

/**
 * Created by fist on 2016-09-10.
 */
public class PresenterBinder {

	public static void bind(MainView mainView) {
		MainPresenter mainPresenter = new MainPresenter();
		mainView.setPresenter(mainPresenter);
		mainPresenter.attachView(mainView);
	}
}
