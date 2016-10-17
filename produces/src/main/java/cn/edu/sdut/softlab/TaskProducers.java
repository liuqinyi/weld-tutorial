/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.sdut.softlab;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;

/**
 *
 * @author SuBaochen:subaochen@126.com
 */
@SessionScoped
public class TaskProducers implements Serializable{
  TaskType taskType = TaskType.ASYNC;
  
  /**
   * change from @RequestScoped to @ApplicationScoped to see what happened.
   * 
   * @TODO why @SessionScoped failed here?
   * @param asyncTask
   * @param syncTask
   * @return 
   */
  @Produces @Preferred @RequestScoped
  public Task getTask (AsyncTask asyncTask,SyncTask syncTask) {
    System.out.println("getTask called......");
    switch(taskType) {
      case ASYNC: return asyncTask;
      case SYNC: return syncTask;
      default: return null;
    }
  }
  
}