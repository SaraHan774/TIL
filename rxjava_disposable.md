1. CompositeDisposable clear() vs dispose() 

clear() : 모두 다 clear 하지만, 새로운 disposable 을 받을 수 있다. 

dispose() : 모두 다 clear 하고, isDisposed = true 로 설정되도록 하여서 새로운 disposable 을 accept 하지 않는다. 