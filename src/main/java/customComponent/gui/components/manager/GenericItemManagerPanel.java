package customComponent.gui.components.manager;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import customComponent.gui.components.SelectionObserverButton;
import customComponent.gui.components.globalslavepanel.GlobalSlavePanel;
import customComponent.gui.components.itemslist.GenericItemsListPanel;
import customComponent.gui.components.observer.SelectionObserver;
import customComponent.project.observer.KnowledgeBaseObserver;

public abstract class GenericItemManagerPanel<E extends Comparable<E>> extends javax.swing.JPanel implements SelectionObserver {
	private static final Logger logger = LoggerFactory.getLogger(GenericItemManagerPanel.class);
	  /** Creates new form GenericItemManagerPanel */
	  public GenericItemManagerPanel(GenericItemsListPanel<E> genericItemsListPanel, 
	                                 GlobalSlavePanel<E> globalSlavePanel) {
	    
	    this.genericItemsListPanel = genericItemsListPanel;
	    this.globalSlavePanel = globalSlavePanel;

	    initComponents();

	    this.itemsListPanel.add(this.genericItemsListPanel);
	    this.slaveScrollPanel.setViewportView(this.globalSlavePanel);
	    this.genericItemsListPanel.addSelectionObserver(this);
	    
	  }

	  /**
	   * 
	   * @param title
	   */
	  public void setMasterPanelTitle(String title) {

	    masterScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(title));
	  }

	  /**
	   * 
	   * @param title
	   */
	  public void setSlavePanelTitle(String title) {

	    slaveScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(title));
	  }

	  /**
	   * 
	   * @param selection
	   */
	  public void selectionChangeHappened(int[] selection) {
		  logger.info("Selection happend");
	    if (selection.length == 0) {

	      this.globalSlavePanel.refresh(null);

	    } else if (selection.length == 1) {
	      
	      this.globalSlavePanel.refresh(this.genericItemsListPanel.getItem(selection[0]));
	      
	    } else {

	      this.globalSlavePanel.refresh(null);
	    }
	  }

	  public abstract void addAction();
	  public abstract void removeAction(ArrayList<E> items);
	  public abstract void moveToAction(ArrayList<E> items);

	  /** This method is called from within the constructor to
	   * initialize the form.
	   * WARNING: Do NOT modify this code. The content of this method is
	   * always regenerated by the Form Editor.
	   */
	  @SuppressWarnings("unchecked")
	  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	  private void initComponents() {

	    mainSplitPanel = new javax.swing.JSplitPane();
	    masterScrollPanel = new javax.swing.JScrollPane();
	    masterPanel = new javax.swing.JPanel();
	    itemsListPanel = new javax.swing.JPanel();
	    separator = new javax.swing.JSeparator();
	    addButton = new javax.swing.JButton();
	    moveToButton = new SelectionObserverButton(2,-1);
	    this.genericItemsListPanel.addSelectionObserver(moveToButton);
	    deleteButton = new SelectionObserverButton(1,-1);
	    this.genericItemsListPanel.addSelectionObserver(this.deleteButton);
	    slaveScrollPanel = new javax.swing.JScrollPane();

	    mainSplitPanel.setBorder(null);
	    mainSplitPanel.setDividerLocation(400);

	    masterScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

	    itemsListPanel.setLayout(new javax.swing.BoxLayout(itemsListPanel, javax.swing.BoxLayout.LINE_AXIS));

	    addButton.setText("Add");
	    addButton.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(java.awt.event.ActionEvent evt) {
	        addButtonActionPerformed(evt);
	      }
	    });

	    moveToButton.setText("Move to");
	    moveToButton.setEnabled(false);
	    moveToButton.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(java.awt.event.ActionEvent evt) {
	        moveToButtonActionPerformed(evt);
	      }
	    });

	    deleteButton.setText("Delete");
	    deleteButton.setEnabled(false);
	    deleteButton.addActionListener(new java.awt.event.ActionListener() {
	      public void actionPerformed(java.awt.event.ActionEvent evt) {
	        deleteButtonActionPerformed(evt);
	      }
	    });

	    javax.swing.GroupLayout masterPanelLayout = new javax.swing.GroupLayout(masterPanel);
	    masterPanel.setLayout(masterPanelLayout);
	    masterPanelLayout.setHorizontalGroup(
	      masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterPanelLayout.createSequentialGroup()
	        .addContainerGap()
	        .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	          .addComponent(itemsListPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
	          .addGroup(masterPanelLayout.createSequentialGroup()
	            .addComponent(addButton)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(moveToButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	          .addComponent(separator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
	        .addContainerGap())
	    );
	    masterPanelLayout.setVerticalGroup(
	      masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterPanelLayout.createSequentialGroup()
	        .addComponent(itemsListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	        .addGroup(masterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	          .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	          .addComponent(moveToButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	          .addComponent(addButton))
	        .addContainerGap())
	    );

	    masterScrollPanel.setViewportView(masterPanel);

	    mainSplitPanel.setLeftComponent(masterScrollPanel);

	    slaveScrollPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
	    mainSplitPanel.setRightComponent(slaveScrollPanel);

	    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	    this.setLayout(layout);
	    layout.setHorizontalGroup(
	      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	      .addComponent(mainSplitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
	    );
	    layout.setVerticalGroup(
	      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	      .addComponent(mainSplitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
	    );
	  }// </editor-fold>//GEN-END:initComponents

	  /**
	   *
	   * @param evt
	   */
	  private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
	    addAction();
	  }//GEN-LAST:event_addButtonActionPerformed

	  /**
	   * 
	   * @param evt
	   */
	  private void moveToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveToButtonActionPerformed
	    
	    moveToAction(this.genericItemsListPanel.getSelectedItems());
	  }//GEN-LAST:event_moveToButtonActionPerformed

	  /**
	   * 
	   * @param evt
	   */
	  private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
	    
	    removeAction(this.genericItemsListPanel.getSelectedItems());
	  }//GEN-LAST:event_deleteButtonActionPerformed

	  /**
	   * 
	   * @param evt
	   */
	  // Variables declaration - do not modify//GEN-BEGIN:variables
	  private javax.swing.JButton addButton;
	  private SelectionObserverButton deleteButton;
	  private javax.swing.JPanel itemsListPanel;
	  private javax.swing.JSplitPane mainSplitPanel;
	  private javax.swing.JPanel masterPanel;
	  private javax.swing.JScrollPane masterScrollPanel;
	  private SelectionObserverButton moveToButton;
	  private javax.swing.JSeparator separator;
	  private javax.swing.JScrollPane slaveScrollPanel;
	  // End of variables declaration//GEN-END:variables
	  private GenericItemsListPanel<E> genericItemsListPanel;
	  private GlobalSlavePanel<E> globalSlavePanel;

	}