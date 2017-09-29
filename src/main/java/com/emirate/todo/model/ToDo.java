/**
 * 
 */
package com.emirate.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Todo Model dto
 * 
 * @author ntanwa
 *
 */

@Entity
public class ToDo {

	// Id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	// Message of TODO
	private String msg;

	// Status Pending or Completed
	private String status;

	
	/**
	 * 
	 */
	public ToDo() {
	}

	/**
	 * @param msg
	 * @param status
	 */
	public ToDo(String msg, String status) {
		this.msg = msg;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ToDo [id=" + id + ", msg=" + msg + ", status=" + status + "]";
	}
}
