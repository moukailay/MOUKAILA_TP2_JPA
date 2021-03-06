package com.tp2;

import com.tp2.persistence.*;
import com.tp2.service.AdminService;
import com.tp2.service.EmployeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bibliotheque {

    public static void main ( String[] args ) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

        AdminService adminService = new AdminService( new EmployeRepoDAO() );

        adminService.createEmploye(
                "YAHAYA" ,
                "MOUKAILA" ,
                "789 rue javaHibernateJPA" );

        EmployeService employeService = new EmployeService(
                new ClientRepoDAO() ,
                new LivreRepoDAO() ,
                new CdRepoDAO() ,
                new DvdRepoDAO() ,
                new DocumentRepoDAO() ,
                new PretDocumentRepoDAO() );

        employeService.createClient(
                "ARTTURI LEHKONEN" ,
                "LEHKONEN" ,
                "27, rue des CM" );

        employeService.createClient(
                "NICK" ,
                "SUZUKI" ,
                "26, rue des Canadiens" );

        employeService.createLivre(
                "Les belles-Soeurs" ,
                "Michel Tremblay" ,
                "L'Abeille" ,
                simpleDateFormat.parse( "2012-06-22" ) ,
                "roman" ,
                true ,
                21 ,
                250 );

        employeService.createLivre( "Un Homme et son pécher" ,
                "Claude-Henry Gagnon" ,
                "Libraires" ,
                simpleDateFormat.parse( "1960-10-12" ) ,
                "fiction" ,
                true ,
                21 ,
                500 );

        employeService.createCd(
                "Disturbed" ,
                "Godsmack" ,
                "Universal" ,
                simpleDateFormat.parse( "2016-10-12" ) ,
                "Rock'n'Roll" ,
                true ,
                14 ,
                120 );

        employeService.createCd(
                "Nothing Else Matters" ,
                "Apocalyptica" ,
                "SunSystem" ,
                simpleDateFormat.parse( "2020-01-12" ) ,
                "Heavy Metal" ,
                true ,
                14 ,
                120 );

        employeService.createDvd(
                "Manipulation" ,
                "Sun White" ,
                "Hollywood" ,
                simpleDateFormat.parse( "2013-11-10" ) ,
                "Action" ,
                true ,
                7 ,
                120 );

        employeService.createDvd( "L'ombre de mon ex" ,
                "pascal" ,
                "Shadow" ,
                simpleDateFormat.parse( "2020-01-12" ) ,
                "Intrigue" ,
                true ,
                7 ,
                120 );

        //Recherche document par titre
        System.out.println( "Document par titre" );
        System.out.println( employeService.findByTitre( "Les belles-Soeurs" ) );
        System.out.println();

        //Recherche document par auteur
        System.out.println( "Document par auteur" );
        System.out.println( employeService.findByAuteur( "Michel Tremblay" ) );
        System.out.println();

        //Recherche document par catégorie
        System.out.println( "Document par catégorie" );
        //var document = employeService.findByCategorie("fiction" );
        System.out.println( employeService.findByCategorie( "fiction" ) );
        System.out.println();

        //Recherche document par an de publication
        System.out.println( "Document par année de publication" );
        System.out.println( employeService.findByAnnee( "2020" ) );
        System.out.println();

        //ENREGISTREMENT DES PRETS DE DOCUMENTS<<<<<<<<<<<<<<<<<<<<<<
        employeService.createPret ( new Date() , employeService.findClientById ( 11 ) ,
                                   employeService.findDocumentById( 20 ) );

        employeService.createPret ( new Date() , employeService.findClientById ( 12 ) ,
                                   employeService.findDocumentById( 21 ) );

        employeService.createPret ( new Date() , employeService.findClientById ( 11 ) ,
                                   employeService.findDocumentById( 24 ) );

        //Affichage des documents empruntés par le client (id client=11)
        employeService.findAllPretDocument( employeService.findClientById ( 11 ) );

        //ENREGISTREMENT pret DOCUMENTS (document déjà en cours d'emprunt)<<<<<<<<<<<<<<<<<<<<<<
        //échec d'emprunt
        //System.out.println();
       employeService.createPret ( new Date() , employeService.findClientById ( 12 ) ,
                                   employeService.findDocumentById( 24 ) );
    }
}
