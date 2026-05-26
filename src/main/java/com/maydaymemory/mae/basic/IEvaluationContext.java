package com.maydaymemory.mae.basic;

/**
 * 动画求值上下文。
 * <p>
 * 在 Animation.evaluate() 求值期间可用，携带与当前求值相关的运行时信息
 * （如播放进度、实体引用等）。实现类可通过 {@link #prepareEvaluation(float)}
 * 钩子在每次求值前同步自身状态。
 * </p>
 *
 * @since 1.1.3
 */
public interface IEvaluationContext {
    /**
     * 获取当前播放进度（秒）。
     *
     * @return 当前播放进度，单位为秒
     */
    float getTimeS();

    /**
     * 在 Animation.evaluate() 开始时被调用。
     * <p>
     * 实现类可在此钩子中同步运行时状态，例如更新时间戳、
     * 刷新缓存的实体属性等。默认实现为空。
     * </p>
     *
     * @param timeS 当前求值时间点，单位为秒
     */
    default void prepareEvaluation(float timeS) {}
}
