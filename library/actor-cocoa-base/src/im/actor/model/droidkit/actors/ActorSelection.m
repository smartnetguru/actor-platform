//
//  Generated by the J2ObjC translator.  DO NOT EDIT!
//  source: /Users/ex3ndr/Develop/actor-model/library/actor-cocoa-base/build/java/im/actor/model/droidkit/actors/ActorSelection.java
//


#line 1 "/Users/ex3ndr/Develop/actor-model/library/actor-cocoa-base/build/java/im/actor/model/droidkit/actors/ActorSelection.java"

#include "J2ObjC_source.h"
#include "im/actor/model/droidkit/actors/ActorSelection.h"
#include "im/actor/model/droidkit/actors/Props.h"

@interface DKActorSelection () {
 @public
  DKProps *props_;
  NSString *path_;
}

@end

J2OBJC_FIELD_SETTER(DKActorSelection, props_, DKProps *)
J2OBJC_FIELD_SETTER(DKActorSelection, path_, NSString *)


#line 10
@implementation DKActorSelection


#line 14
- (instancetype)initWithDKProps:(DKProps *)props
                   withNSString:(NSString *)path {
  DKActorSelection_initWithDKProps_withNSString_(self, props, path);
  return self;
}


#line 19
- (DKProps *)getProps {
  return props_;
}

- (NSString *)getPath {
  return path_;
}

@end


#line 14
void DKActorSelection_initWithDKProps_withNSString_(DKActorSelection *self, DKProps *props, NSString *path) {
  (void) NSObject_init(self);
  
#line 15
  self->props_ = props;
  self->path_ = path;
}


#line 14
DKActorSelection *new_DKActorSelection_initWithDKProps_withNSString_(DKProps *props, NSString *path) {
  DKActorSelection *self = [DKActorSelection alloc];
  DKActorSelection_initWithDKProps_withNSString_(self, props, path);
  return self;
}

J2OBJC_CLASS_TYPE_LITERAL_SOURCE(DKActorSelection)
