package videolibrary.street.quality.qualityshow.api.user.helpers;

import android.content.Context;

import java.util.LinkedHashMap;
import java.util.Map;

import videolibrary.street.quality.qualityshow.api.user.callbacks.FilmsCallbacks;
import videolibrary.street.quality.qualityshow.api.user.callbacks.SerieCallbacks;
import videolibrary.street.quality.qualityshow.api.user.callbacks.UserCallbacks;
import videolibrary.street.quality.qualityshow.api.user.dao.Film;
import videolibrary.street.quality.qualityshow.api.user.dao.Serie;
import videolibrary.street.quality.qualityshow.api.user.dao.User;
import videolibrary.street.quality.qualityshow.api.user.listeners.FilmListener;
import videolibrary.street.quality.qualityshow.api.user.listeners.SerieListener;
import videolibrary.street.quality.qualityshow.api.user.listeners.UserListener;
import videolibrary.street.quality.qualityshow.api.user.repositories.UserRepository;
import videolibrary.street.quality.qualityshow.api.user.utils.ApiAdapter;
import videolibrary.street.quality.qualityshow.api.user.utils.ApiConstants;

/**
 * Created by elerion on 10/26/15.
 * Class containing all function util for use User on api Server
 */
public class UserHelper {

    private final ApiAdapter apiAdapter;
    private final UserRepository userRepository;

    private final String EMAIL      = "email";
    private final String USENAME    = "username";
    private final String PASSWORD   = "password";
    private final String REALM      = "realm";

    /**
     * Contructor
     * @param context context of current application
     */
    public UserHelper(Context context) {
        apiAdapter = new ApiAdapter(context, ApiConstants.API_URL);
        userRepository = apiAdapter.createRepository(UserRepository.class);
    }

    public void users(UserListener listener){
        userRepository.findAll(new UserCallbacks.GetAllUsers(listener));
    }

    /**
     * Login function
     * @param email     email of user who want to login
     * @param password  password of user who want to login
     * @param listener  listener for received all informations about login
     */
    public void login(String email, String password, UserListener listener){
        userRepository.loginUser(email, password, new UserCallbacks.LoginCallback(listener));
    }

    /**
     * Update an existing user, the user must contain only [realm, username, email, password, created(optional), lastupdate(optional)]
     * @param user      user need to update
     * @param listener  listener for received all informations
     */
    public void update(User user, UserListener listener){
        user.save(new UserCallbacks.UpdateCallback(listener));
    }

    /**
     * Delete an existing user
     * @param user      user that we want delete
     * @param listener  listener for received all informations
     */
    public void delete(User user, UserListener listener){
        user.destroy(new UserCallbacks.DeleteCallback(listener));
    }

    /**
     * Create a new user, you need to create user just with [realm, username, email, password, created(optional), lastupdate(optional)]
     * @param listener  listener for received all informations
     */
    public void create(String username, String email, String password, String realm, UserListener listener){
        Map<String, String> map = new LinkedHashMap<>();
        map.put(this.EMAIL, email);
        map.put(this.USENAME, username);
        map.put(this.REALM, realm);
        map.put(this.PASSWORD, password);

        userRepository.createObject(map).save(new UserCallbacks.CreateCallback(listener));
    }

    /**
     * Get user and films in the same time, you can choose if you want the categories
     * @param user          Current user
     * @param listener      Listener about user actions
     * @param categories    Boolean about include categories
     */
    public void films(User user,boolean categories, FilmListener listener){
        userRepository.getFilms((int) user.getId(), categories, new FilmsCallbacks.GetFilmsCallback(listener));
    }

    public void addFilm(User user, Film film, FilmListener listener){
        userRepository.addFilm((int) user.getId(), film, new FilmsCallbacks.AddFilmCallback(listener));
    }

    public void deleteFilm(User user, int filmId, FilmListener listener){
        userRepository.deleteFilm((int) user.getId(), filmId, new FilmsCallbacks.DeleteFilmCallback(listener));
    }

    public void series(User user, boolean categories, SerieListener listener){
        userRepository.getSeries((int) user.getId(), categories, new SerieCallbacks.GetSeriesCallback(listener));
    }

    public void addSerie(User user, Serie serie, SerieListener listener){
        userRepository.addSerie((int) user.getId(), serie, new SerieCallbacks.AddSerieCallback(listener));
    }

    public void deleteSerie(User user, int serieId, SerieListener listener){
        userRepository.deleteSerie((int) user.getId(), serieId, new SerieCallbacks.DeleteSerieCallback(listener));
    }

}