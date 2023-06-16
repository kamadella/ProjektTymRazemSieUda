package org.example.models;

public interface Forum {

    public Long addAdvertise(String text, String title, Long idCategory, Long idUser);
    public void deleteAdvertise(Long id);
    public void updateAdvertise(String text, String title, Long idCategory, boolean status);

    public Long addUser(String password, String login, String email);
    public void deleteUser(Long idUser);

    public Long addCategory(String name);
    public void deleteCategory(String name);
    public void updateCategory(String name);



}
