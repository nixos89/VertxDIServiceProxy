package com.ns.vertx.pgplain;

public class DBQueries {
	public static String CREATE_CATEGORY_TABLE_SQL = "CREATE TABLE IF NOT EXISTS Category (category_id BIGSERIAL PRIMARY KEY, name VARCHAR(30), is_deleted boolean);";	
	public static String GET_ALL_CATEGORIES_SQL = "SELECT category_id, name, is_deleted FROM Category;";
	public static String GET_CATEGORY_BY_ID_SQL = "SELECT category_id, name, is_deleted FROM Category WHERE category_id = $1;";
	public static String CREATE_CATEGORY_SQL = "INSERT INTO Category (name, is_deleted) VALUES($1, $2) RETURNING category_id;";
	public static String UPDATE_CATEGORY_SQL = "UPDATE Category SET name = $1, is_deleted = $2 WHERE category_id = $3 RETURNING category_id;"; 
	public static String DELETE_CATEGORY_BY_ID_SQL = "DELETE FROM Category WHERE category_id = $1;";
}
