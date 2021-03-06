package org.robolectric.shadows;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Shadows;
import org.robolectric.TestRunners;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TestRunners.WithDefaults.class)
public class ShadowAnimatorTest {

  @Test
  public void shouldBeAbleToStart() throws Exception {
    Animator animator = new StubAnimator();
    TestAnimatorListener startListener = new TestAnimatorListener();
    TestAnimatorListener endListener = new TestAnimatorListener();
    animator.addListener(startListener);
    animator.addListener(endListener);

    Shadows.shadowOf(animator).start();
    assertThat(startListener.startWasCalled).isTrue();

    assertThat(endListener.endWasCalled).isTrue();
  }

  @Test
  public void shouldBeAbleToNotifyListenersOfStartAndEnd() throws Exception {
    Animator animator = new StubAnimator();
    TestAnimatorListener startListener = new TestAnimatorListener();
    TestAnimatorListener endListener = new TestAnimatorListener();
    animator.addListener(startListener);
    animator.addListener(endListener);

    Shadows.shadowOf(animator).notifyStart();
    assertThat(startListener.startWasCalled).isTrue();

    Shadows.shadowOf(animator).notifyEnd();
    assertThat(endListener.endWasCalled).isTrue();
  }

  private static class StubAnimator extends Animator {
    @Override
    public long getStartDelay() {
      return 0;
    }

    @Override
    public void setStartDelay(long startDelay) {
    }

    @Override
    public Animator setDuration(long duration) {
      return null;
    }

    @Override
    public long getDuration() {
      return 0;
    }

    @Override
    public void setInterpolator(TimeInterpolator value) {
    }

    @Override
    public boolean isRunning() {
      return false;
    }
  }
}
