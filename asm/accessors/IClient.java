package org.powerbuddy.asm.accessors;

/**
 * User: Matt
 * Date: 1/7/13
 * Time: 10:06 AM
 */
public interface IClient {

    public int getConnectionState();

    public int getWidgetIndex();

    public int getMinimapAngel();

    public int getMinimapScale();

    public int getMinimapOffset();

    public IPlayer[] getPlayerArray();

    public ILandscapeInfo getLandscapeInfo();

    public IItemDefinition getSelectedItem();

}
