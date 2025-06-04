package Filtros;

import java.awt.image.BufferedImage;

public abstract class AbstractFilter implements ImageFilter{
  abstract public BufferedImage filter(BufferedImage image);
}
