package com.yl.myproject.patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteWatched implements Watched
{
    // ��Ź۲���
    private List<Watcher> list = new ArrayList<Watcher>();

    public void addWatcher(Watcher watcher)
    {
        list.add(watcher);
    }

    public void removeWatcher(Watcher watcher)
    {
        list.remove(watcher);
    }

    public void notifyWatchers(String str)
    {
        // �Զ�����ʵ������������е��õ�
        for (Watcher watcher : list)
        {
            watcher.update(str);
        }
    }

}
