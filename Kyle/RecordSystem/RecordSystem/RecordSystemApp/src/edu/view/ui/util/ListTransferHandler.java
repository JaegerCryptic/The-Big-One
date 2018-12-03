package edu.view.ui.util;

import edu.view.ui.classes.ClassRegistration;
import javax.swing.TransferHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;

public class ListTransferHandler extends TransferHandler {

    private int[] indices = null;
    private int addIndex = -1; //Location where items were added
    private int addCount = 0; //Number of items added.

    private ClassRegistration parentForm = null;

    public ListTransferHandler(ClassRegistration parentForm) {
        this.parentForm = parentForm;
    }

    public boolean canImport(TransferHandler.TransferSupport info) {
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
    }

    protected Transferable createTransferable(JComponent c) {
        return new StringSelection(exportString(c));
    }

    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY_OR_MOVE;
    }

    public boolean importData(TransferHandler.TransferSupport info) {
        if (!info.isDrop()) {
            return false;
        }

        JList list = (JList) info.getComponent();
        DefaultListModel listModel = (DefaultListModel) list.getModel();
        JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
        int index = dl.getIndex();
        boolean insert = dl.isInsert();

// Get the string that is being dropped.
        Transferable t = info.getTransferable();
        String data;
        try {
            data = (String) t.getTransferData(DataFlavor.stringFlavor);
        } catch (Exception e) {
            return false;
        }

// Perform the actual import. 
        if (insert) {
            listModel.add(index, data);
        } else {
            listModel.set(index, data);
        }
        return true;
    }

    protected void exportDone(JComponent c, Transferable data, int action) {
        try {
            cleanup(c, action == TransferHandler.MOVE);
        } catch (Exception e) {
        }

    }

    protected String exportString(JComponent c) {
        JList list = (JList) c;
        indices = list.getSelectedIndices();
        java.util.List values = list.getSelectedValuesList();

        StringBuffer studentList = new StringBuffer();

        for (int index = 0; index < values.size(); index++) {

            String validStudentId = extractValidStudentId(values.get(index));

            if (null != validStudentId) {
                studentList.append(validStudentId);
            }
        }

        return studentList.toString();
    }

    private String extractValidStudentId(Object studentData) {

        if (studentData == null || studentData.toString().split(" - ").length == 0) {
            return null;
        }

        String studentId = studentData.toString().split(" - ")[0];
        if (!parentForm.getStudentIdList().contains(studentId)) {
            return (studentId + " ; ");
        } else {
            return null;
        }
    }

    protected void importString(JComponent c, String str) {
        JList target = (JList) c;
        DefaultListModel listModel = (DefaultListModel) target.getModel();
        int index = target.getSelectedIndex();
        if (indices != null && index >= indices[0] - 1
                && index <= indices[indices.length - 1]) {
            indices = null;
            return;
        }

        int max = listModel.getSize();
        if (index < 0) {
            index = max;
        } else {
            index++;
            if (index > max) {
                index = max;
            }
        }
        addIndex = index;
        String[] values = str.split("\n");
        addCount = values.length;
        for (int i = 0; i < values.length; i++) {
            listModel.add(index++, values[i]);
        }
    }

    protected void cleanup(JComponent c, boolean remove) {
        if (remove && indices != null) {
            JList source = (JList) c;
            DefaultListModel model = (DefaultListModel) source.getModel();

            if (addCount > 0) {
                for (int i = 0; i < indices.length; i++) {
                    if (indices[i] > addIndex) {
                        indices[i] += addCount;
                    }
                }
            }
            for (int i = indices.length - 1; i >= 0; i--) {
                model.remove(indices[i]);
            }
        }
        indices = null;
        addCount = 0;
        addIndex = -1;
    }
}
