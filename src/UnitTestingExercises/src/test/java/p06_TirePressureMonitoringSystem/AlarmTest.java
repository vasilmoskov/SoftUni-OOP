package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    @Test
    public void testAlarmShouldBeOnWhenPressureValueUnderThreshold() {
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.90);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnWhenPressureValueAboveThreshold() {
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.10);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOffWhenPressureValueIsInRange() {
        Sensor sensor = Mockito.mock(Sensor.class);

        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.00);

        Alarm alarm = new Alarm(sensor);

        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }
}
