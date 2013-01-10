package org.powerbuddy.asm.accessors;

/**
 * User: Matt
 * Date: 1/7/13
 * Time: 9:51 AM
 */
public interface ICharacter {

    public IModel[] getModels();

    public String getOverheadText();

    public Object getAnimationQueue();

    public IAnimator getActiveAnimator();

    public IAnimator getPassiveAnimator();

    public Object getCombatList();

    public double /*?*/ getOrientation(); // 3.1, 3.2, 3.5, 4.1 - 4.4, 5.1 - 5.6, 7.1 - 7.4, 9.2 - 9.4, 10.1, 10.2, 11.1 - 11.4, 11.7

}
