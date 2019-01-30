package UD04_P01_BDOO;

import java.sql.*;
import java.util.HashSet;

import org.neodatis.odb.ODB;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class E02_Principal {
	
	static ODB bd;
	
	public static void main(String[] args) {
			bd = ODBFactory.open("src\\UD04_P02_BDOO_MySQL_a_Neodatis\\ficheros\\ARTICULOS.DAT");
			bd.close();
	}

} // fin clase