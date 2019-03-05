package com.televizor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TelevizorBaza {
	
	private Connection connection;
	private ResultSet rs = null;

	public ResultSet baza(Televizor tv){

        String uslovInternet;
        String uslovTipEkrana;
        String uslovRezolucija;
        
        switch (tv.getInternet()) {
		case WIFI:
			uslovInternet = "`internet` = 'WIFI'";
			break;
		case BEZWIFIJA:
			uslovInternet = "(`internet` = 'WIFI' OR `internet` = 'BEZWIFIJA')";
			break;
		case NE:
			uslovInternet = "(`internet` = 'WIFI' OR `internet` = 'BEZWIFIJA' OR `internet` = 'NE')";
			break;
		default:
			uslovInternet = " ";
			break;
		}
        
        switch (tv.getTipEkrana()) {
		case LED:
			uslovTipEkrana = "`tipEkrana` = 'LED'";
			break;
		case OLED:
			uslovTipEkrana = "(`tipEkrana` = 'OLED' OR `tipEkrana` = 'QLED' OR `tipEkrana` = 'LED')";
			break;
		case QLED:
			uslovTipEkrana = "(`tipEkrana` = 'QLED' OR `tipEkrana` = 'LED')";
			break;
		default:
			uslovTipEkrana = " ";
			break;
		}
        
        switch (tv.getRezolucija()) {
		case HD:
			uslovRezolucija = "(`rezolucija` = 'HD' OR `rezolucija` = 'FULLHD')";
			break;
		case FULLHD:
			uslovRezolucija = "(`rezolucija` = 'FULLHD' OR `rezolucija` = 'UHD')";
			break;
		case UHD:
			uslovRezolucija = "(`rezolucija` = 'FULLHD' OR `rezolucija` = 'UHD')";
			break;
		default:
			uslovRezolucija = " ";
			break;
		}

	String sql = "SELECT * FROM `Televizor` WHERE `maxCena` <= "+tv.getCena()+" AND "+uslovInternet+" AND `tuner` LIKE '%"+tv.getTuner()+"%' AND `dijagonala` BETWEEN "+(tv.getDijagonala()-3)+" AND "+(tv.getDijagonala()+3)+" AND "+uslovTipEkrana+" AND `smart` = '"+tv.getSmart()+"' AND `brojPortova` >= "+tv.getBrojPortova()+" AND "+uslovRezolucija;
    rs = popunaRS(sql);
    try {
		if(!rs.next()){
			sql = "SELECT * FROM `Televizor` WHERE `maxCena` <= "+tv.getCena()+" AND "+uslovInternet+" AND `tuner` LIKE '%"+tv.getTuner()+"%' AND "+uslovTipEkrana+" AND `smart` = '"+tv.getSmart()+"' AND `brojPortova` >= "+tv.getBrojPortova()+" AND "+uslovRezolucija;
			rs = popunaRS(sql);
				if(!rs.next()){
					sql = "SELECT * FROM `Televizor` WHERE `maxCena` <= "+tv.getCena()+" AND "+uslovInternet+" AND `tuner` LIKE '%"+tv.getTuner()+"%' AND `smart` = '"+tv.getSmart()+"' AND `brojPortova` >= "+tv.getBrojPortova();
					rs = popunaRS(sql);
					if(!rs.next()){
						sql = "SELECT * FROM `Televizor` WHERE `maxCena` <= "+tv.getCena()+" AND `smart` = '"+tv.getSmart()+"' AND `brojPortova` >= "+tv.getBrojPortova();
						rs = popunaRS(sql);
					}else{
						rs.previous();
					}
				}else{
				rs.previous();
			}
		}else{
			rs.previous();
		}
	} catch (SQLException e1) {
		System.out.println("Gre\u0161ka u sql upitu");
		e1.printStackTrace();
	}
    return rs;
}
	
	private ResultSet popunaRS(String sql){
		ResultSet result = null;
		//televizor = new Televizor();
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Gre\u0161ka nije prona\u0111en drajver");
			e.printStackTrace();
		}
        try {
			connection = DriverManager.getConnection("jdbc:mysql://www.db4free.net:3306/televizorexpert?useUnicode=true&characterEncoding=utf-8&useSSL=false", "bokidukic2fon", "BokiDukic-993");
			connection.setAutoCommit(false);
        } catch (SQLException e) {
        	System.out.println("Gre\u0161ka u povezivanju");
			e.printStackTrace();
		}

        System.out.println(sql);
        Statement sqlStatement = null;
		try {
			sqlStatement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Gre\u0161ka u kreiranju stejtmenta");
			e.printStackTrace();
		}
		try {
			result = sqlStatement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Gre\u0161ka u izvr\u0161enju");
			e.printStackTrace();
		}
		return result;
	}
	
	public void zatvoriKonekciju(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Gre\u0161ka u zatvaranju konekcije");
			e.printStackTrace();
		}
	}
	
}
