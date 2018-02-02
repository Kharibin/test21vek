import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderLinePageComponent } from './order-line-page.component';

describe('OrderLinePageComponent', () => {
  let component: OrderLinePageComponent;
  let fixture: ComponentFixture<OrderLinePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderLinePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderLinePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
