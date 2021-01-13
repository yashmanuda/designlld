package designlld.decoratorpattern;

/**
 *
 * @param <T> type T component which will be decorated by other decorators
 */
abstract class Component<T> {
    /**
     * @return T type instance i.e. description of the component
     */
    abstract T getDescription();
}
