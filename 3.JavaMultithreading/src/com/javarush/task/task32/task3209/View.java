package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        switch (a.getActionCommand()) {
            case "Новый" :
                controller.createNewDocument();
                break;
            case "Открыть" :
                controller.openDocument();
                break;
            case "Сохранить" :
                controller.saveDocument();
                break;
            case "Сохранить как..." :
                controller.saveDocumentAs();
                break;
            case "Выход" :
                controller.exit();
                break;
            case "О программе" :
                showAbout();
        }
    }

    //19.6. Если .
    //19.7. Если "О программе", то вызови метод showAbout() у представления.

    @Override
    public void pack() {
        super.pack();
    }

    public void init () {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        this.setVisible(true);
    }

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        //9.1.3. Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому, как это мы делали с панелью вкладок.
        //9.2. Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение (look and feel) нашего приложения такими же,
        // как это определено в системе.
        //Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler.
        //
        //Подсказа: для реализации задания используй класс UIManager.
        //
        //Запусти приложение, теперь ты должен видеть панель с меню вверху окна. Некоторые из пунктов меню (например: Вырезать,
        // Копировать, Вставить, Стиль (частично), Выравнивание, Цвет, Шрифт) должны уже работать. Убедись, что все работает и только затем продолжи разработку.
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlScrollPane = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", htmlScrollPane);
        JScrollPane textScrollPane = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", textScrollPane);
        tabbedPane.setPreferredSize(new Dimension(400, 400));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

   public void initGui() {
        initMenuBar();
        initEditor();
        pack();
   }

   public void selectedTabChanged() {
        switch (tabbedPane.getSelectedIndex()){
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
   }
    public void exit() {
        controller.exit();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    // void undo() - отменяет последнее действие. Реализуй его используя undoManager.
    // Метод не должен кидать исключений, логируй их.
    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }

    //11.5.2. void redo() - возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.
    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    //11.5.5. Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.
    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        int a = tabbedPane.getSelectedIndex();
        boolean rez = false;
        if (a == 0) rez = true;
        return rez;
    }

    public void selectHtmlTab() {
       if (!isHtmlTabSelected())
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this, "Cool HTML chenger" , "Abut program", JOptionPane.INFORMATION_MESSAGE);
    }
}
