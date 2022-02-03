package com.emanuel.alkemychallenge

import android.app.Application
//Base class for maintaining global application state. You can provide your own implementation by
// creating a subclass and specifying the fully-qualified name of this subclass as the "android:name"
// attribute in your AndroidManifest.xml's <application> tag. The Application class, or your subclass of the
// Application class, is instantiated before any other class when the process for your application/package is created
import dagger.hilt.android.HiltAndroidApp
//Annotation for marking the Application class where the Dagger components should be generated.
// Since all components will be built in the same compilation as the annotated application,
// all modules and entry points that should be installed in the component need to be transitive
// compilation dependencies of the annotated application.
//Usage of this annotation is similar to AndroidEntryPoint with the only difference being that it
// only works on application classes and additionally triggers Dagger component generation.
//This annotation will generate a base class that the annotated class should extend, either directly
// or via the Hilt Gradle Plugin. This base class will take care of injecting members into the Android
// class as well as handling instantiating the proper Hilt components at the right point in the lifecycle.
// The name of the base class will be "Hilt_ ".
@HiltAndroidApp
class AlkemyChallengeApp: Application()
//Called when the application is starting, before any activity, service, or receiver objects
// (excluding content providers) have been created.
//Implementations should be as quick as possible (for example using lazy initialization of state)
// since the time spent in this function directly impacts the performance of starting the first activity,
// service, or receiver in a process.
//If you override this method, be sure to call super.onCreate().
//Be aware that direct boot may also affect callback order on Android Build.VERSION_CODES.N and later
// devices. Until the user unlocks the device, only direct boot aware components are allowed to run.
// You should consider that all direct boot unaware components, including such android.content.ContentProvider,
// are disabled until user unlock happens, especially when component callback order matters.