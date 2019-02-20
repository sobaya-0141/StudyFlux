package sobaya.app.studyflux.flux

import io.reactivex.processors.FlowableProcessor
import io.reactivex.processors.PublishProcessor

class Dispatcher {

    private val dispatcherProcessor: FlowableProcessor<Action<*>>
            = PublishProcessor.create<Action<*>>()

    fun <T> dispatch(action: Action<T>) {
        dispatcherProcessor.onNext(action)
    }

    fun on(type: String) = dispatcherProcessor.filter { it.type == type }
}