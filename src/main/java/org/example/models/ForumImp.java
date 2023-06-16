package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class ForumImp implements Forum{


    List<Category> listCategory = new ArrayList<Category>();
    List<Advertise> listAdvertise = new ArrayList<Advertise>();
    List<Admin> listAdmin = new ArrayList<Admin>();
    List<User> listUser = new ArrayList<User>();


    @Override
    public Long addAdvertise(String text, String title, Long idCategory, Long idUser) {
        return null;
    }

    @Override
    public void deleteAdvertise(Long id) {

    }

    @Override
    public void updateAdvertise(String text, String title, Long idCategory, boolean status) {

    }

    @Override
    public Long addUser(String password, String login, String email) {
        return null;
    }

    @Override
    public void deleteUser(Long idUser) {

    }

    @Override
    public Long addCategory(String name) {
        return null;
    }

    @Override
    public void deleteCategory(String name) {

    }

    @Override
    public void updateCategory(String name) {

    }
}
