package pl.training.githubbrowser.view;

import pl.training.githubbrowser.presenter.MainPresenter;
import pl.training.githubbrowser.presenter.Presenter;

/**
 * Created by fist on 2016-09-10.
 */
public interface MvpView {
	void setPresenter(MainPresenter presenter);
}
