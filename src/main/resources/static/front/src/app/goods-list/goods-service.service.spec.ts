import { TestBed, inject } from '@angular/core/testing';

import { GoodsServiceService } from './goods-service.service';

describe('GoodsServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GoodsServiceService]
    });
  });

  it('should be created', inject([GoodsServiceService], (service: GoodsServiceService) => {
    expect(service).toBeTruthy();
  }));
});
