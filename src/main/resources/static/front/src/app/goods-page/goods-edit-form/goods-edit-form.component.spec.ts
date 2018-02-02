import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GoodsEditFormComponent } from './goods-edit-form.component';

describe('GoodsEditFormComponent', () => {
  let component: GoodsEditFormComponent;
  let fixture: ComponentFixture<GoodsEditFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GoodsEditFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GoodsEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
