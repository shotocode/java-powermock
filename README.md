# java-powermockito
1. Mocking new instance creations (default constructor)
   PowerMockito.whenNew(Child.class).withNoArguments().thenReturn(mockChild);
   
   Mocking new instance creation with arguments
   PowerMockito.whenNew(Child.class).withArguments(Mockito.anyString()).thenReturn(mockChild);
