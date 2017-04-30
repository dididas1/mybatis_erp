package kr.or.dgit.erp.dao;

import java.util.Vector;

public class DataDao<T> {
	private Vector<T> vector;

	public DataDao() {
		loadData();
	}

	private void loadData() {
		vector = new Vector<>();
		
	}
	
	public void insertItem(T item){
		if(!vector.contains(item)){
			vector.add(item);
		}
	}
	public void updateItem(T item){
		if(vector.contains(item)){
			vector.set(vector.indexOf(item), item);
		}
	}
	
	public void deleteItem(T item){
		if(vector.contains(item)){
			vector.remove(item);
		}
	}
	
	public int getLastNum(){
		return vector.size();
	}
	
	public Vector<T> selectAllItems(){
		return vector;
	}
	
	public T selectByIdx(T item){
		return vector.get(vector.indexOf(item));
	}

	public void setVector(Vector<T> vector) {
		this.vector = vector;
	}
	
}
