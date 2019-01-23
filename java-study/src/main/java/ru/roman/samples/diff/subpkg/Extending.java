package ru.roman.samples.diff.subpkg;

import ru.roman.samples.diff.ExtendingWithClone;

/**
 * @author дтоь 12.01.2008
 */
// расширить класс из другого пакета можно только если он  public
public class Extending extends ExtendingWithClone {

    @Override
    public void foo1() {
    }

    // метод определенный как packaged в другом пакете не переопределяется, 
    //а просто реализуется новый метод 
    private void foo2() {
    }

    @Override
    public void foo3() {
    }

    // метод определенный как private в другом пакете не переопределяется,
    //а просто реализуется новый метод 
    private void foo4() {
    }
}
