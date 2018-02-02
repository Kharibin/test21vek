import { TestBed, inject } from '@angular/core/testing';

import { OrderLineServiceService } from './order-line-service.service';

describe('OrderLineServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OrderLineServiceService]
    });
  });

  it('should be created', inject([OrderLineServiceService], (service: OrderLineServiceService) => {
    expect(service).toBeTruthy();
  }));
});
