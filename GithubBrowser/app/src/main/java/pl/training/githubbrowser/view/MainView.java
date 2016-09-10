package pl.training.githubbrowser.view;

import java.util.List;

import pl.training.githubbrowser.model.Repository;

/**
 * Created by fist on 2016-09-10.
 */
public interface MainView extends MvpView {

	void showRepositories(List<Repository> repositories);


}
