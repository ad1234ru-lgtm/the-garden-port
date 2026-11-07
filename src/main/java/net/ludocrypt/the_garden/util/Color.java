package net.ludocrypt.the_garden.util;

public class Color {
    private int value;
    private Color(int rgb) { this.value = (0xFF000000 | rgb); }
    private Color(int r, int g, int b) { this(r, g, b, 255); }
    private Color(int r, int g, int b, int a) { this.value = ((a & 0xFF) << 24 | (r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF) << 0); }

    public static Color colorOf(int rgb) { return new Color(rgb); }
    public static Color colorOf(int r, int g, int b) { return new Color(r, g, b); }
    public static int of(int r, int g, int b) { return new Color(r, g, b).getRGB(); }

    public int getRed() { return this.getRGB() >> 16 & 0xFF; }
    public int getGreen() { return this.getRGB() >> 8 & 0xFF; }
    public int getRGB() { return this.value; }
    public int getBlue() { return this.getRGB() & 0xFF; }
}