import java.sql.SQLException;

public class Add {
	/*This class contains method that adds new record*/
	
	//adding chosen record
	public static String addClient(String imie, String nazwisko, String id_konto) {
		String add = String.format("INSERT INTO klienci (imie, nazwisko, id_konto) VALUES ('%s', '%s', %s);", imie, nazwisko, id_konto);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B��d przy dodawaniu klienta.\nSprawd� numer konta";
        }
        return "Klienta dodano pomy�lnie.";
	}
	
	//adding chosen record
	public static String addProduct(String id_produkty, String nazwa, String cena) {
		String add = String.format("INSERT INTO produkty (imie, nazwisko, id_konto) VALUES ('%s', '%s', %s);", id_produkty, nazwa, cena);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B��d przy dodawaniu produktu.\nKod produktu ju� wyst�pi� w bazie danych.";
        }
        return "Produkt dodano pomy�lnie.";
	}
	
	//adding chosen record
	public static String addTransaction(String id_klienci, String id_produkty, String data_zakupy) {
		String add = String.format("INSERT INTO zakupy (imie, nazwisko, id_konto) VALUES ('%s', '%s', %s);", id_klienci, id_produkty, data_zakupy);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B��d przy dodawaniu tranzakcji.";
        }
        return "Tranzakcj� dodano pomy�lnie.";
	}
	
	//adding chosen record
	public static String addAccount(String id_konto, String kwota, String nazwisko) {
		String add = String.format("INSERT INTO konto (imie, nazwisko, id_konto) VALUES ('%s', '%s', %s);", id_konto, kwota, nazwisko);
        try {
            SQLite.stat.execute(add);
        } catch (SQLException e) {
            e.printStackTrace();
            return "B��d przy dodawaniu konta.\nNazwisko nie mo�e pozosta� puste.";
        }
        return "Konto dodano pomy�lnie.";
	}
}