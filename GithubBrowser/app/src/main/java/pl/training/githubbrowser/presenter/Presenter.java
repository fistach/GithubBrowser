package pl.training.githubbrowser.presenter;

import pl.training.githubbrowser.view.MvpView;

/**
 * Created by fist on 2016-09-10.
 */
public interface Presenter<V extends MvpView> {

	void attachView(V view);

	void detachView();
}
