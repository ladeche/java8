Streams are different from an array or collection in that they are not a data structure. 
They do not occupy permanent memory and are transient in nature.

There are two primary benefits to using streams:
    They are more succinct than an equivalent collection implementation
    They have the potential to improve performance by taking advantage of multiple processors

Using a stream instead of a collection means:
    No need for an explicit declaration of intermediate variables or storage
    Potential for lazy evaluation
    More flexibility in design using a more natural style (pipeline)
    Potential for automatic parallelization

There are several aspects of streams that need to be kept in mind during their use. These include:
    Streams do not store elements
    Streams can be unbounded
    Streams do not modify the original source
    Streams may be ordered
    Automatic parallelization is possible

1) Utilisation différenciée stream vs collection
    