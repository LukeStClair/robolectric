package org.robolectric;

import javax.annotation.Generated;

import org.robolectric.annotation.processing.objects.AnyObject;
import org.robolectric.annotation.processing.objects.Dummy;
import org.robolectric.annotation.processing.shadows.ShadowAnything;
import org.robolectric.annotation.processing.shadows.ShadowDummy;
import org.robolectric.internal.ShadowExtractor;
import org.robolectric.util.ShadowProvider;

@Generated("org.robolectric.annotation.processing.RoboProcessor")
@SuppressWarnings({"unchecked","deprecation"})
public class Shadows implements ShadowProvider {

  public static final Class<?>[] DEFAULT_SHADOW_CLASSES = {
    ShadowAnything.class,
    ShadowDummy.class,
  };
  
  public static ShadowAnything shadowOf(AnyObject actual) {
    return (ShadowAnything) ShadowExtractor.extract(actual);
  }
  
  public static ShadowDummy shadowOf(Dummy actual) {
    return (ShadowDummy) ShadowExtractor.extract(actual);
  }
  
  public void reset() {
    ShadowAnything.anotherResetter();
    ShadowDummy.resetter_method();
  }
}
