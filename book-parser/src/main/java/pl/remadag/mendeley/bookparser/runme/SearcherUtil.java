/*
 * Created on 06.09.12
 *
 * Copyright (c) 2002-2010 ComArch S.A.
 *
 * Ten plik zrodlowy jest wlasnoscia firmy ComArch S.A. Uzytkownikiem
 * tego pliku moze byc jedynie osoba upowazniona przez ComArch S.A. z wylaczeniem
 * dostepu osob trzecich.
 *
 * Osoba, ktora znalazla sie w posiadaniu niniejszego pliku nie posiadajac
 * legitymacji prawnej do otrzymania takiego materialu, zobowiazana jest do
 * niezwlocznego zwrocenia niniejszego pliku na adres firmy:
 *
 *  ComArch S.A., al. Jana Pawla II 39a, 31-864 Krakow
 *
 * Rozpowszechnianie, kopiowanie, rozprowadzanie lub inne dzialania o podobnym
 * charakterze jest prawnie zabronione pod rygorem sankcji przewidzianych
 * w szczegolowych regulacjach prawnych.
 */
package pl.remadag.mendeley.bookparser.runme;

import com.mendeley.oapi.schema.Author;
import com.mendeley.oapi.schema.Document;

/**
 * Class
 *
 * @author Marcin Gadamer
 */
public class SearcherUtil {

    public static String getAuthorsMapKey(Author author) {
        return author.getSurname() + " " + author.getForename();
    }

    public static String getDocumentsMapKey(Document document) {
        return document.getTitle().trim().toLowerCase();
    }

}
