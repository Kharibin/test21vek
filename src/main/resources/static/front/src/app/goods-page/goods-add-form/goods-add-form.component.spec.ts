import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodsAddFormComponent } from './goods-add-form.component';

describe('GoodsAddFormComponent', () => {
  let component: GoodsAddFormComponent;
  let fixture: ComponentFixture<GoodsAddFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodsAddFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodsAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
