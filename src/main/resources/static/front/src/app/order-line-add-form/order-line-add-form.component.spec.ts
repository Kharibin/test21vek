import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderLineAddFormComponent } from './order-line-add-form.component';

describe('OrderLineAddFormComponent', () => {
  let component: OrderLineAddFormComponent;
  let fixture: ComponentFixture<OrderLineAddFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OrderLineAddFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderLineAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
