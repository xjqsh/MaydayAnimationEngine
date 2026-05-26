package com.maydaymemory.mae.basic;

/**
 * Represents a keyframe that supports interpolation between adjacent keyframes.
 * 
 * <p>This interface extends {@link Keyframe} to provide additional interpolation capabilities.
 * It includes methods to access pre and post values for interpolation, as well as the
 * interpolator to be used for this keyframe.</p>
 * 
 * @param <T> the type of value stored in this keyframe
 */
public interface InterpolatableKeyframe<T> extends Keyframe<T> {
    /**
     * This value will be used to interpolate with the previous keyframe.
     * 
     * @return the pre-interpolation value
     */
    T getPre();

    /**
     * This value will be used to interpolate with the subsequent keyframe.
     * 
     * @return the post-interpolation value
     */
    T getPost();

    /**
     * This value will be used to interpolate with the previous keyframe,
     * with an evaluation context for dynamic keyframes.
     *
     * @param ctx the evaluation context, may be null
     * @return the pre-interpolation value
     */
    default T getPre(IEvaluationContext ctx) {
        return getPre();
    }

    /**
     * This value will be used to interpolate with the subsequent keyframe,
     * with an evaluation context for dynamic keyframes.
     *
     * @param ctx the evaluation context, may be null
     * @return the post-interpolation value
     */
    default T getPost(IEvaluationContext ctx) {
        return getPost();
    }

    /**
     * Get interpolator this keyframe using.
     * When interpolating, this interpolator may not be used.
     * Which interpolator will be used is decided by their priority.
     *
     * @return the interpolator for this keyframe
     * @see Interpolator#getPriority()
     */
    Interpolator<T> getInterpolator();
}
